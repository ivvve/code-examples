from django.db import models as m


class ContentField(m.CharField):
    pass


class Board(m.Model):
    content = ContentField(null=False, max_length=100)


class Reply(m.Model):
    board = m.ForeignKey(Board, null=False, on_delete=m.CASCADE)
    content = ContentField(null=False, max_length=100)
