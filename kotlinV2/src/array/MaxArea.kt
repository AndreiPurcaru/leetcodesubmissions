package array

fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.lastIndex
    var maxVolume = 0

    while (left < right) {
        val currentVolume = minOf(height[left], height[right]) * (right - left)
        maxVolume = maxOf(maxVolume, currentVolume)

        if (height[left] < height[right]) {
            left ++
        } else {
            right--
        }
    }
    return maxVolume
}

fun maxAreaBrute(height: IntArray): Int {
    var maxVolume = 0
    var currentVolume: Int

    for (i in height.indices) {
        for (j in i + 1..<height.size) {
            currentVolume = minOf(height[i], height[j]) * (j - i)
            if (currentVolume > maxVolume ) {
                maxVolume = currentVolume
            }
        }
    }

    return maxVolume
}

fun main() {
    println(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}