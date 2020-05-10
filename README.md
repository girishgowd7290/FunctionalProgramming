# Java :: Fucntional Programming: 
(Summary in package com.codemads.functional.programming10)

# Fucntional Programming 1: 
1. Streams
2. Filter
3. Map
4. reduce
5. distinct
6. sorted - reverse order, Comparator.comparing()
7. collect
8. Predicate(Objet, Boolean), MapperFunctions(InObject,OutObject), Consumer(Object, Void)
9. Behavioural approach

# Fucntional Programming 2: 
1. Supplier - No Args but returns a value
2. UnaryOperator - Takes only one arguement; return type is same as arguement
3. BiPredicate - Takes two input params n returns a boolean value
4. BiFucntion - Takes two input params n returns a  value
5. BiConsumer - Takes two input params n returns nothing
6. IntBinaryOperator - Takes 2 Integer params n return the Integer type
7. IntConsumer - Consumes a Integer type param and performs operation. Doesn return anything
8. IntFunction - Takes Integer as param always and returns the data type value defined
9. IntPredicate - Takes Integer as param and returns Boolean value
10. IntSupplier - No Input args but returns a Integer value
11. IntToDoubleFunction function - Takes Integer as input param and returns Double value
12. IntToLongFunction function - Takes Integer as input param and returns Long value
13. Int Unary Operator - Takes Integer as only  param and returns the Integer value
14. To create a new Object - Supplier<Object> object = Object::new;


# Fucntional Programming 3: 
1. IntStreams	
 		- range(int, int)
 		- rangeClosed(int, int)
 		- iterate(1, exp).limit(int);
 		- iterate(1, exp).limit(int).boxed().collect(Collectors.toList()))
2. Parallel() 
3. Operating on List elements - Immutability concept
4. File Operatios
 		- Print all lines (	Files.lines(Paths.get("filename")).forEach(System.out::println);)
 		- Read all files from a Directory
 		- Check isDirectory
 

# Fucntional Programming 4: 
1. Collectors.joining("<>") - Merges all elements to a String
2. Split every Item of a list - USe flatMap(Arrays::stream)
3. Nested Loops / Streams
4. Intermediary functions - findFirst(), findAny(), Peek() - elements while streaming

# Fucntional Programming 5: 
1. Filters
2. allMatch, noneMatch, anyMatch
3. Sorting : Increasing, Decreasing, Multiple Sorting Conditions
4. Comparator.comparing(exp).thenComapring(exp2)
5. skip (int) & Limit(int)
6. Take while(lambda)  - checks the condition, as long its true it will print. If it gets any element not matching then it drops rest
7. drop while(lambda) - Check for the condition, as long as its true it will drop the elements 
8. min, max with Comparator:: stream.min(Comparator.comparing(exp)), stream.max(Comparator.comparing(exp))
9. findFirst() on Sorted Stream:: stream.sorted(numofStudComparatorInc).findFirst();
10.findAny() on Sorted Stream :: stream.sorted(numofStudComparatorInc).findAny();
11. Stream().findFirst().orElse(new Object());
12. count() - To find the count of elements in a list (satisfying some condition may be)
13. sum() - get the sum of some field after mapping the field
14. average() - get the average of some field after mapping the field
15. GroupingBy() - stream().collect(Collectors.groupingBy(Object :: Field));
16. GroupingBy & Tolist - stream().collect(Collectors.groupingBy(Object :: Field, Collectors.mapping(Object::Field, Collectors.toList())));
17. GroupingBy & Summ - stream().collect(Collectors.groupingBy(Object :: Field, Collectors.summingInt(Object::Field)));
18. GroupingBy & Count - stream().collect(Collectors.groupingBy(Object :: Field, Collectors.counting()));
