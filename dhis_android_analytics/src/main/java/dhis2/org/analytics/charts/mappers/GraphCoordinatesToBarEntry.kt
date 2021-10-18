package dhis2.org.analytics.charts.mappers

import com.github.mikephil.charting.data.BarEntry
import dhis2.org.analytics.charts.data.Graph
import dhis2.org.analytics.charts.data.GraphPoint

class GraphCoordinatesToBarEntry {
    fun map(
        graph: Graph,
        coordinates: List<GraphPoint>,
        serieIndex: Int,
        seriesCount: Int
    ): List<BarEntry> {
        return coordinates.mapIndexed { index, graphPoint ->
            BarEntry(
                when {
                    seriesCount > 1 -> groupedBarIndex(index, serieIndex, seriesCount)
                    else -> singleBarIndex(index, graphPoint, graph)
                },
                graphPoint.fieldValue
            )
        }
    }

    private fun groupedBarIndex(index: Int, serieIndex: Int, seriesCount: Int): Float {
        return index.toFloat() +
            (
                default_bar_group_space * serieIndex.toFloat() / seriesCount.toFloat() -
                    default_gap / 2f +
                    default_bar_group_separation
                )
    }

    private fun singleBarIndex(index: Int, graphPoint: GraphPoint, graph: Graph): Float {
        return if (index > 0) {
            graphPoint.position ?: graph.numberOfStepsToDate(graphPoint.eventDate)
        } else {
            index.toFloat()
        }
    }
}
