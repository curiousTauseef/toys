OWNED_ROOM = 0
NOT_OWNED_ROOM = 1
DUCT_STARTS = 2
DUCT_ENDS = 3

def node_identifier(i,j):
	return "%d,%d" % (i,j)

def find_hamiltonian_paths(graph, start, end, path=[]):
	pass

w, h = [int(x) for x in raw_input().split()]
grid = []

for i in xrange(h):
	grid.append([int(x) for x in raw_input().split(" ")])

graph = {}
duct_starts_at = None
duct_ends_at = None
num_of_rooms_to_pass = 2 #Minimum of two for the start and end of the duct

for i in xrange(h):
	for j in xrange(w):
		
		if grid[i][j] == NOT_OWNED_ROOM:
			continue 
		elif grid[i][j] == DUCT_STARTS:
			duct_starts_at = node_identifier(i,j)
		elif grid[i][j] == DUCT_ENDS:
			duct_ends_at = node_identifier(i,j)
		else:
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

print len(find_hamiltonian_paths(graph, duct_starts_at, duct_ends_at))
