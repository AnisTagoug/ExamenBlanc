from django.urls import path
#from . import views
from .views import *
urlpatterns= [
    path('index/',index),
    path('affiche/<str:classe>',affiche),
    path('afficheEvt/',ListEvt),
    path('List/',ListEvtGeneric.as_view(),name='aff'),
    path('Detail/<str:title>',Detail,name='D'),
    path('Ajout/',AjoutEvt,name="add")
]