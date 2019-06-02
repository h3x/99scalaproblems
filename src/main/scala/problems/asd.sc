val l = List('a', 'b', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
val lsorted = l.sorted


lsorted.span(_ == l.head)

def pack(l:List[List[Char]], rem:List[Char]): List[List[Char]] = {
    rem match {
      case Nil => l
      case h::tail => pack( l +: rem.span(_ == h), tail)
  }
}