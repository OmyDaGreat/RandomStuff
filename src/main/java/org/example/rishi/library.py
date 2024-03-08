import pybel

c = pybel.search(".b.j.pf")
print(c[0].hexagon + " " + c[0].wall + " " + c[0].shelf + " " + c[0].volume + " " + c[0].page)
