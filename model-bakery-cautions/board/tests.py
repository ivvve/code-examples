from django.test import TestCase
from model_bakery import baker

from board.models import Board, Reply


class ModelBakeryTest(TestCase):
    def test_make_saves_fixture_data_in_db(self):
        reply = baker.make(Reply)

        self.assertIsNotNone(Board.objects.get(pk=reply.board.pk))
        self.assertIsNotNone(Reply.objects.get(pk=reply.pk))

    def test_make_when_non_null_value_is_None_then_throws_error(self):
        try:
            baker.make(Reply, board=None)  # Exception should be raised

            self.fail()
        except Exception as exception:
            print(exception.__class__)  # <class 'django.db.utils.IntegrityError'>
            print(exception)  # NOT NULL constraint failed: board_reply.board_id

    def test_prepare_does_not_save_fixture_data_in_db(self):
        reply = baker.prepare(Reply, _save_related=True)

        self.assertIsNone(reply.pk)

    def test_prepare_when_save_related_is_True_then_saves_related_model_fixture_in_db(self):
        reply = baker.prepare(Reply, _save_related=True)

        self.assertIsNotNone(Board.objects.get(pk=reply.board.pk))
        self.assertIsNone(reply.pk)
