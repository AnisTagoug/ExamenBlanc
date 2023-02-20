from django.contrib import admin
from .models import *
# Register your models here.
#admin.site.register(Person)

@admin.register(Person)
class PersonAdmin(admin.ModelAdmin):
    list_display=('username','cin','email')
    list_per_page=2
    list_filter=('cin','email','username')
    search_fields = ['username']
    fieldsets=[
        ('Donneés confidentielles',{
        "fields":(
        'first_name',
        'last_name',
        'email',
        'username',
        'password',
        
        )
        }),
        ('Permissions',{
         "fields":(
         'groups',
         'user_permissions',
         'is_staff',
         'is_active',
         'is_superuser'
         ) 
        }),
         ('Dates',{
         "fields":(
         'last_login',
         'date_joined',
         ) 
        }),
    ]
