def mostPointOneLine(points):
# map {slope, counter}
# also consider {slope=0 when vertical, counter}
# for each-for each other points
    res = 0
    for index, point in point:
        same = 1 # current point
        sameX = 0 # vertical slope
        most_slope = 0
        for other_index, other_point in points:
            slope_count = {}
            if index == other_index:
                continue
            elif point.x == other_point.x:
                sameX += 1
            else:
                slope = (point.y - other_point.y) / (point.x - other_point.x)
                if slope in slope_count:
                    slope_count[slope] += 1
                else:
                    slope_count[slope] = 1
                most_slope = max(most_slope, slope_count[slope])
        most_slope = max(most_slope, sameX) + same
        res = max(res, most_slope)
