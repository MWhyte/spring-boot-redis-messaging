### spring-boot-redis-messaging
A project to mess around with spring redis messaging and different types of disconnects

#### Killing redis and debugging reconnect:

##### Silent kill use redis [client kill](https://redis.io/commands/client-kill)

Find you connection
> 127.0.0.1:6379> CLIENT LIST

> id=11 addr=127.0.0.1:50280 fd=10 name= age=773 idle=0 flags=N db=0 sub=0 psub=0 multi=-1 qbuf=26 qbuf-free=32742 obl=0 oll=0 omem=0 events=r cmd=client


> CLIENT KILL 127.0.0.1:50454`

`OK`

Spring does not detect the disconnect
 
##### Restart redis use 
> brew services restart redis

Spring detects disconnect and reconnects once redis is available
