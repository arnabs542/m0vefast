def isRectangleOverlap(self, rec1: List[int], rec2: List[int]) -> bool:
    '''
    [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
    and (x2, y2) are the coordinates of its top-right corner.
    https://yeqiuquan.blogspot.com/2018/05/836-rectangle-overlap.html
    if no overlap, rect2 could be only in four positions
            ;; (x2, y2)
    ;;(x1, y1)
    '''
    # top bottom left right
    if rec2[y1] > rec1[y2] or rec2[y2] < rec1[y1] or rec2[x2] < rec1[x1] or rec2[x1] > rec1[x2]:
        return False
    return True

    if rec2[1] >= rec1[3] or rec2[3] =< rec1[1] or rec2[2] =< rec1[0] or rec2[0] >= rec1[2]:
        return False
    return True
