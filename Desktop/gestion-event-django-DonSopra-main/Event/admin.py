from django.contrib import admin,messages
#from Event.models
from .models import *
from datetime import datetime
from Person.models import Person

# Register your models here.
class ParticipationsAdmin(admin.StackedInline):
    model=Event_Participation
    extra=2

class DateListFilter(admin.SimpleListFilter):
    title= 'Event Date'
    parameter_name='event_date'
    def lookups(self,request,model_admin):
        return (
            ('Past Event' , ('Past Event')),
            ('Upcoming Events',('Upcoming Events')),
            ('Today Event',('Today Event'))
        )
    def queryset(self, request, queryset):
        if self.value()=='Past Event':
            return queryset.filter(event_date__lt=datetime.now())
        if self.value()=='Upcoming Events':
            return queryset.filter(event_date__gt=datetime.now())
        if self.value()=='Today Event':
            return queryset.filter(event_date__exact=datetime.now())
class NbreParticipantFilter(admin.SimpleListFilter):
    title='Nombre participants'
    parameter_name='nbe_participant'
    def lookups(self,request,model_admin):
        return (
            ('0' , ('0')),
            ('More',('More')),
            
        )
    def queryset(self, request, queryset):
        if self.value()=='0':
            return queryset.filter(nbe_participant__exact=0)
        if self.value()=='More':
            return queryset.filter(nbe_participant__gt=0)
       
     

#@admin.register(Person)
#class SearchPerson(admin.ModelAdmin):
#    search_fields=['username']

def set_True(ModelAdmin,request,queryset):
    req=queryset.update(state=True)
    if req==1:
        message="1 event was"
    else:
        message=f"{req} events were"
    messages.success(request,message="%s successfully accepted" %message)

set_True.short_description="Accept"
    



@admin.register(Event)
class EventAdmin(admin.ModelAdmin):
    def set_false(self,request,queryset):
        req=queryset.filter(state=False)
        if(req.count()>0):
            messages.error(request,f"{req.count()} events are already marked refused")
        else:
            req_update=queryset.update(state=False)
            if req_update==1:
                message="1 event was"
            else:
                message=f"{req_update} events were"
                messages.success(request,message="%s successfully marked refused" %message)
    set_false.short_description="Refused"    
    def evt_participation(self,obj):
        return obj.participations.count()     

    list_display=('title','description','nbe_participant','state','event_date','creation_date','update_date','organizer','image','evt_participation')
    list_per_page=2
    list_filter=('title',DateListFilter,NbreParticipantFilter)
    fieldsets=(
        ('A propos', {
            "fields":(
                'title','description','image'
            ),
        }),
        ('Date', {
            "fields":(
                'event_date','creation_date','update_date'
            )
        }),
        ('Others', {
            "fields":(
                'category','state','nbe_participant'
            )
        }),
        ('Personnel', {
            "fields":(
                'organizer',
            )
        })

    )
    actions=[set_True,set_false]
    readonly_fields=['creation_date','update_date']
    inlines=(ParticipationsAdmin,)
    autocomplete_fields=['organizer']
#admin.site.register(Event,EventAdmin)
