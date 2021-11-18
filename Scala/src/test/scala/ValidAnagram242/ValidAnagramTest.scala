package ValidAnagram242

import org.scalatest.flatspec.AnyFlatSpec

class ValidAnagramTest extends AnyFlatSpec {

    "Strings" should "return false when they have different lengths" in {
        assert(!ValidAnagram.isAnagram("anagram", "lollipop"))
    }

    it should "return false if they are not anagrams" in {
        assert(!ValidAnagram.isAnagram("anagram", "nagraml"))
    }

    it should "return true if they are anagrams" in {
        assert(ValidAnagram.isAnagram("anagram", "nagrama"))
    }
}
