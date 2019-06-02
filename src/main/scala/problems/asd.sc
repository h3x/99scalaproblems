val list = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')

list.flatMap({ x=> List.fill(5)(x) })
val i = 5

val (l, _) = list.zipWithIndex.filter({case(e,n) => n % i != i-1 }).unzip
l


list.splitAt(-2)

val j = 2
val(l1, l2) = list.splitAt(list.length - j)
l2 ::: l1

val( l3, l4) = list.splitAt(j+1)
val el = l3.last
val(l5,l6) = l3.splitAt(l3.length-1)
(l5 ::: l4, l6.head)