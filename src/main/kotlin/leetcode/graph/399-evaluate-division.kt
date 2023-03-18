package leetcode.graph

class EvaluateDivision {

    val graph = HashMap<String, MutableList<Pair<String, Double>>>()

    private fun dfs(visited: HashSet<String>, currentValue: Double, start: String, des: String): Double {
        graph[start]?.forEach {
            if (it.first == des) return currentValue * it.second
            if (visited.add(it.first)) {
                val res = dfs(visited, currentValue * it.second, it.first, des)
                if (res != -1.0) return res
            }
        }
        return -1.0
    }

    private fun calcEquation(
        equations: List<List<String>>,
        values: DoubleArray,
        queries: List<List<String>>
    ): DoubleArray {
        equations.forEachIndexed { idx, equation ->
            graph.putIfAbsent(equation[0], mutableListOf())
            graph[equation[0]]?.add(Pair(equation[1], values[idx]))

            graph.putIfAbsent(equation[1], mutableListOf())
            graph[equation[1]]?.add(Pair(equation[0], 1 / values[idx]))
        }

        val res = DoubleArray(queries.size)
        queries.forEachIndexed { idx, query ->
            res[idx] = dfs(HashSet<String>(), 1.0, query[0], query[1])
        }

        return res
    }

    operator fun invoke(
        equations: List<List<String>>,
        values: DoubleArray,
        queries: List<List<String>>
    ): DoubleArray {
        return calcEquation(equations, values, queries)
    }
}