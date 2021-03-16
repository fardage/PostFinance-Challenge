import numpy as np
import six
import sys
sys.modules['sklearn.externals.six'] = six
import mlrose


dist_list1 = [
    (0, 6, 0.00000000000000000001),
    (0, 1, 7.615773105863909),
    (0, 2, 8.246211251235321),
    (1, 0, 7.615773105863909),
    (1, 3, 4.123105625617661),
    (2, 0, 8.246211251235321),
    (2, 4, 4.47213595499958),
    (2, 5, 7.280109889280518),
    (3, 5, 4.47213595499958),
    (4, 6, 7.0710678118654755),
    (5, 6, 5.0)
]

dist_list2 = [
    (0, 6, 0.00000000000000000001),
    (0, 1, 4.47213595499958),
    (0, 3, 8.06225774829855),
    (1, 2, 9.848857801796104),
    (1, 0, 4.47213595499958),
    (2, 3, 9.055385138137417),
    (2, 4, 8.602325267042627),
    (3, 4, 4.47213595499958),
    (3, 5, 7.0),
    (4, 6, 9.0),
    (5, 6, 4.0)
]

dist_list3 = [
    (0, 6, 0.00000000000000000001),
    (0, 1, 2.8284271247461903),
    (1, 2, 3.605551275463989),
    (2, 3, 6.324555320336759),
    (2, 4, 10.0),
    (3, 6, 8.06225774829855),
    (4, 5, 12.165525060596439),
    (5, 6, 8.06225774829855),
]

dist_list4 = [
    (0, 1, 4.123105625617661),
    (1, 2, 11.045361017187261),
    (1, 5, 9.055385138137417),
    (2, 3, 8.602325267042627),
    (2, 4, 7.0710678118654755),
    (3, 6, 8.06225774829855),
    (4, 6, 7.810249675906654),
    (5, 6, 6.708203932499369)
]


fitness_dists = mlrose.TravellingSales(distances=dist_list1)
problem_fit = mlrose.TSPOpt(length=7, fitness_fn=fitness_dists)
best_state, best_fitness = mlrose.genetic_alg(problem_fit, max_attempts=1000)
print(best_state)
print(best_fitness)

fitness_dists = mlrose.TravellingSales(distances=dist_list2)
problem_fit = mlrose.TSPOpt(length=7, fitness_fn=fitness_dists)
best_state, best_fitness = mlrose.genetic_alg(problem_fit, max_attempts=1000)
print(best_state)
print(best_fitness)

fitness_dists = mlrose.TravellingSales(distances=dist_list3)
problem_fit = mlrose.TSPOpt(length=7, fitness_fn=fitness_dists)
best_state, best_fitness = mlrose.genetic_alg(problem_fit, max_attempts=1000)
print(best_state)
print(best_fitness)


fitness_dists = mlrose.TravellingSales(distances=dist_list4)
problem_fit = mlrose.TSPOpt(length=7, fitness_fn=fitness_dists)
best_state, best_fitness = mlrose.genetic_alg(problem_fit, max_attempts=1000)
print(best_state)
print(best_fitness)