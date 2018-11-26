### spring-boot-redis-messaging
A project to mess around with spring redis messaging

##### Killing redis and debugging reconnect:

- Silent kill use redis [client kill](https://redis.io/commands/client-kill)

`127.0.0.1:6379> CLIENT LIST`
 
`id=11 addr=127.0.0.1:50280 fd=10 name= age=773 idle=0 flags=N db=0 sub=0 psub=0 multi=-1 qbuf=26 qbuf-free=32742 obl=0 oll=0 omem=0 events=r cmd=client`

`id=19 addr=127.0.0.1:50454 fd=8 name= age=12 idle=2 flags=P db=0 sub=0 psub=1 multi=-1 qbuf=0 qbuf-free=0 obl=0 oll=0 omem=0 events=r cmd=psubscribe`

`id=20 addr=127.0.0.1:50458 fd=9 name= age=7 idle=2 flags=N db=0 sub=0 psub=0 multi=-1 qbuf=0 qbuf-free=0 obl=0 oll=0 omem=0 events=r cmd=publish`
 
`127.0.0.1:6379> CLIENT KILL 127.0.0.1:50454`

`OK`
 
- Restart redis use `brew services restart redis`
