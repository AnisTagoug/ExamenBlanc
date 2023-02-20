from .models import Event
from django.forms import Textarea
#from .forms import ModelForm
from django import forms

class AddForm(forms.ModelForm):

    class Meta:
        model=Event
        #fields=("__all__")
        fields=("title","description","event_date","organizer")
        widgets={'description':Textarea(
            attrs={'cols':20,'rows':30}
        )},
