# Design an algorithm that takes as input two teams and the heights of the players in the teams and
# checks if it is possible to place players to take the photo subject to the placement constraint.
# A team photo. Each team has 1.1 players, and each player in the back row is taller than the corresponding
# player in the front row.

# check if a team can be place in front of the other team
class Team:
    Player = collections.namedtuple(player, (height))

    def __init__(self, height):
        self._players = [Teams.Player(h) for h in height]

    # O(nlgn)
    # check A's tallest, second tallest taller than B's
    def valid_placement(A, B):
        return all(a < b
                for a, b in zip(sorted(A._players), sorted(B._players)))
        # return all(condition for i, j in XX)
        # a,b in {(2, 'two'), (3, 'three'), (1, 'one')} arr[arr]
        # zip(iterable item, itemrable item)
