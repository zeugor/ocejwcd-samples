Filter example 1
----------------
http://localhost:8080/ocejwcd-samples/FilterTest?type=include
http://localhost:8080/ocejwcd-samples/FilterTest?type=forward
http://localhost:8080/ocejwcd-samples/FilterTest?type=error
http://localhost:8080/ocejwcd-samples/FilterTest // warning as no dispatcher=request dont go inside filter_2, check tail -f catalina.out