# Wait/Notify Example
В данном примере показано, как можно применить wait и notify

Если какой-то поток пытается снять деньги с счета, но их там недостаточно, то он ждет, пока 
его кто-то не разбудит. Если его кто-то разбудил, то он снова проверяет, достаточно ли денег на счете
и так до тех пор, пока их не станет достаточно, после чего отрабатывает логика снятия денег.
Обращаю ваше внимание, что ждущий поток освобождает монитор, пока находится в спячке.

# Чуть подробнее по примеру
Изначальный баланс равен нулю.
Поток Deposit добавляет на баланс по 1 еденице до 50 000 000.
В то же время поток WithDraw пытается снять единовременно 50 000 000, и само собой у него это получится не сразу,
а до тех пор он будет спать.

