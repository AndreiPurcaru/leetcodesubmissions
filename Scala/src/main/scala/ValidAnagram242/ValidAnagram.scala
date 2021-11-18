package ValidAnagram242

object ValidAnagram {
    def isAnagram(s: String, t: String): Boolean = {
        isAnagramDiff(s, t)
    }

    def isAnagramFold(s: String, t: String): Boolean = {
        if (s.length != t.length) return false
        val function = (count: Map[Char, Int], word: Char) => count + (word -> (count.getOrElse(word, 0) + 1))
        val sMap = s.foldLeft(Map.empty[Char, Int])(function)
        val tMap = t.foldLeft(Map.empty[Char, Int])(function)
        sMap == tMap
    }

    def isAnagramDiff(s: String, t: String): Boolean = {
        if (s.length != t.length) return false
        s.diff(t) == ""
    }

    def isAnagramGroupBy(s: String, t: String): Boolean = {
        if (s.length != t.length) return false
        val sMap = s.groupBy(identity).map(element => (element._1, element._2.length))
        val tMap = t.groupBy(identity).map(element => (element._1, element._2.length))
        sMap == tMap
    }

    def isAnagramGroupMapReduce(s: String, t: String): Boolean = {
        if (s.length != t.length) return false
        val sMap = s.groupMapReduce(identity)(_ => 1)(_ + _)
        val tMap = t.groupMapReduce(identity)(_ => 1)(_ + _)
        sMap == tMap
    }
}
