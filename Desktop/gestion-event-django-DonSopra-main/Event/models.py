from django.db import models
from django.utils.timezone import datetime
from Person.models import Person

# Create your models here.


class Event(models.Model):
    title=models.CharField(max_length=255)
    description=models.TextField(max_length=255)
    image=models.ImageField()
    state=models.BooleanField(default=False)
    category_choices=(
        ('Musique','M'),
        ('Cinema','C'),
        ('Sport','S')
    )
    category=models.CharField(max_length=8,choices=category_choices)
    nbe_participant=models.IntegerField('nombre participants',default=0)
    event_date=models.DateField()
    creation_date=models.DateTimeField(auto_now_add=True)
    update_date=models.DateTimeField(auto_now=True)
    organizer=models.ForeignKey(
        Person,
        on_delete=models.CASCADE
        #on_delete=models.SET_NULL,
        #null=True
        #related_name="organisateur"
    )
    participations=models.ManyToManyField(
        Person,
        related_name="participations",
        through="Event_Participation"
    )
    class Meta:
        constraints=[
            models.CheckConstraint(
                check=models.Q(
                    event_date__gte=datetime.now()),
                    name='Date doit etre sup a date sys'
            )
        ]
        verbose_name_plural=("Eventss")
    def __str__(self):
        #return "l'evenement est :"+self.title
        return f"l'evenement est {self.title}"

class Event_Participation(models.Model):
    person=models.ForeignKey(Person,on_delete=models.CASCADE)
    event=models.ForeignKey(Event,on_delete=models.CASCADE)
    participation_date=models.DateField(auto_now=True)
    class Meta:
        unique_together=('person','event')





