1) сделал toUpperCase().trim() для ввода комманд
2) перенёс dao в repository и удалил слой dao
3) реализовал удаление контакта
4) перенес createUser в userController, при этом пришлось le,дублировать в контроллер метод prompt :D

p.s.: не знаю насколько правильно кастовать long в object потом в int, но это помогло реализовать удаление user