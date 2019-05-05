# the hash is (14,2),(12,2),(11,,1),(13,3)
# TODO: do not understand.....
Person = collections.namedtuple('person', ('age', 'name'))
def group_by_age(people):
    age_to_count = collections.Counter([each.age for each in people]) #{12:2, 13:3}
    age_to_offset = {}
    offset = 0
    for age, count in age_to_count.items()
        age_to_offset[age] = offset
        offset += count

    while age_to_offset:
        # make the key iterable, make a iterator
        from_age = next(iter(age_to_offset))
        from_index = age_to_offset[from_age]

        to_age = people[from_index].age
        to_index = age_to_offset[people[from_index].age]
        people[from_index], people[to_index] = people[to_index], people[from_index]

        age_to_count[to_age] -= 1
        if age_to_count[to_age]:
            age_to_offset[to_age] = to_index + 1
        else:
            del age_to_offset[to_age]
