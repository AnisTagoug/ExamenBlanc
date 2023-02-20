from django.contrib.auth.models import AbstractUser
from django.db import models
from django.core.validators import MaxLengthValidator,MinLengthValidator
from django.core.exceptions import ValidationError

# Create your models here.
# def cin_length(v):
#     if len(v)!=8:
#         raise ValidationError("Your CIN must have 8 chara!")
#     return v

def is_mail_esprit(mm):
    if str(mm).endswith('@esprit.tn')==False:
        raise ValidationError( "Your email - {m} - must end with esprit.tn",
                              params={"m":mm})
    return mm

class Person(AbstractUser):
    cin=models.IntegerField('CIN',primary_key=True,validators=[
                        MaxLengthValidator(8),MinLengthValidator(8),
                        ])
    email=models.EmailField(validators=[is_mail_esprit])
    
