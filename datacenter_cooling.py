#!/usr/bin/env python

""" 
Problem description
Datacenter Cooling
We have some rooms in our datacenter, and we need to connect them all with a 
single cooling duct.

Here are the rules:

* The datacenter is represented by a 2D grid.
* Rooms we own are represented by a 0.
* Rooms we do not own are represented by a 1.
* The duct has to start at the air intake valve, which is represented by a 2.
* The duct has to end at the air conditioner, which is represented by a 3.
* The duct cannot go in multiple directions out of the intake or the AC - they 
  must be the two endpoints of the duct.
* The duct must pass through each room exactly once.
* The duct cannot pass through rooms we do not own.
* The duct can connect between rooms horizontally or vertically but not diagonally.

Solution description
To solve this problem I've mapped the rooms on the grid to a graph, ignoring the
rooms that don't belong to us.
The graph is represented as adjacency list and to find the different ways that the duct 
can pass through all the rooms just once, I need to find all Hamiltonian Path in this 
graph that starts at the vertice with the value 2 and ends at the vertice with the value 3

Written by: Felipe Ribeiro <felipernb@gmail.com> - http://about.me/felipernb
"""

OWNED_ROOM = 0
NOT_OWNED_ROOM = 1
DUCT_STARTS = 2
DUCT_ENDS = 3

def node_identifier(i,j):
	return "%d,%d" % (i,j)

def find_hamiltonian_paths(graph, start, end, path=[]):
	pass

# Reads the grid from stdin
w, h = [int(x) for x in raw_input().split()]
grid = []

for i in xrange(h):
	grid.append([int(x) for x in raw_input().split(" ")])

# Builds the adjacency list from the grid, ignoring the nodes with value = 1
graph = {}
duct_starts_at = None
duct_ends_at = None
num_of_rooms_to_pass = 0

for i in xrange(h):
	for j in xrange(w):
		
		if grid[i][j] == NOT_OWNED_ROOM:
			continue 
		elif grid[i][j] == DUCT_STARTS:
			duct_starts_at = node_identifier(i,j)
		elif grid[i][j] == DUCT_ENDS:
			duct_ends_at = node_identifier(i,j)
		
		num_of_rooms_to_pass += 1

		adjacents = []
		if i > 0 and grid[i-1][j] != NOT_OWNED_ROOM:
			adjacents.append(node_identifier(i-1,j))
		if i < h-1 and grid[i+1][j] != NOT_OWNED_ROOM:
			adjacents.append(node_identifier(i+1,j))
		if j > 0 and grid[i][j-1] != NOT_OWNED_ROOM:
			adjacents.append(node_identifier(i,j-1))
		if j < w-1 and grid[i][j+1] != NOT_OWNED_ROOM:
			adjacents.append(node_identifier(i,j+1))

		graph[node_identifier(i,j)] = adjacents

# finds and prints the number of hamiltonian paths
print len(find_hamiltonian_paths(graph, duct_starts_at, duct_ends_at))
