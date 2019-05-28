implicit def any2iterable[A](a: A) : Iterable[A] = Some(a)

val forwards = (1 to 5).zip(5 to 1 by -1).toList
println(forwards)
