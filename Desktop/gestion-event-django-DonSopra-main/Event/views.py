from django.shortcuts import render
from django.http import HttpResponse
from .models import Event
from django.views.generic import *
from .forms import AddForm
from django.http import HttpResponse,HttpResponseRedirect
from django.urls import reverse
# Create your views here.
def index(request):
    return HttpResponse("Bonjour")

def affiche(request,classe):
   
    return render(request,"Event/affiche.html",{"c":classe})

#Methode avec queryset
def ListEvt(request):
    evt=Event.objects.all()
    #affichage via http response
    #resultat="-----".join(e.title for e in evt)
    #return HttpResponse(resultat)
    #affichage via render () => template
    return render(request,'Event/afficheEvt.html',{'e':evt})

#method via generic class
class ListEvtGeneric(ListView):
    model=Event
    context_object_name='e'
    #on garde le temp par def => event_list.html
    fields="__all__"
    template_name="Event/afficheEvt.html"
    ordering=['-event_date']

def Detail(request,title):
    evt=Event.objects.get(title=title)
    return render(request,"Event/Detail.html",{'t':evt})

def AjoutEvt(request):
    if request.method=="GET":
        form= AddForm()
        return render(request,'Event/Ajout.html',{'f':form})
    if request.method=="POST":
        form=AddForm(request.POST)
        if form.is_valid():
            new_evt=form.save(commit=False)
            new_evt.save()
            return HttpResponseRedirect(reverse('aff'))
        else:
            return render(request,'Event/Ajout.html',{'f':form,"msg_erreur":"erreur lors du submit"})

