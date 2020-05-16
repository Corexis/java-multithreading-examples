# Привет!
Это первое демо с самым низкоуровневым api в джаве для работы с потоками.

# Join
- Попробуйте запустить программу из класса Operations.

Сейчас если запустить программу  конечный баланс будет выведен в консоль с неактуальным значением
Это происходит потому, что у нас создается сразу 3 потока, которые работают независимо
Первый Main поток, второй и третий - наши tr1 и tr2.
Чтобы End balance был выведен корректно необходимо прописать join для наших кастомных потоков
для этого необходимо раскомментировать строчки с 15 по 21 в классе Operations.

- Попробуйте запустить программу из класса Operations.

Теперь End balance выводится корректно, только после того, как отработали наши потоки tr1 и tr2

# Synchronized
- Попробуйте запустить программу несколько раз и посмотреть, изменятся ли результаты.

В данном случае результаты можно считать корректными, если начальный и конечный балансы равны
Но как видно на практике, так получается далеко не всегда, и вот банк, который мы обсуживаем или клиент этого банка теряет деньги.

Чтобы исправить этот неприятный момент, необходимо синхронизировать наши методы withDraw и deposit в классе 
BankClient, добавив к ним ключевое слово synchronized.

- Попробуйте несколько раз запустить программу, чтобы убедится, что данные всегда выводятся корректно.

Теперь в наш метод в 1 момент времени может попасть только 1 поток и не выйдет так, что второй поток в это же время
попытается получить доступ к ресурсу и получит некорректные данные.

Так же можно заметить и ощутимое снижение производительности. Чтобы хоть как-то исправить в логических блоках побольше 
рекомендуется делать не целый метод synchronized, а вынести маленький кусочек логики в synchronized блок.
В нашем случае это выглядело бы так:

`
synchronized(this) {
    balance -= amount;
}
`



 
