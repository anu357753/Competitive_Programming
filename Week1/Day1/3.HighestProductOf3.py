def highest_product_of_3(list_of_ints):

    # Calculate the highest product of three numbers
    if len(list_of_ints) < 3:
        return "Not enough elements"
    list_of_ints.sort()
    
    neg_prod = 1
    pos_prod = 1
    neg_count = False
    
    if list_of_ints[0] < 0 and list_of_ints[1] < 0:
        neg_prod *= list_of_ints[0] * list_of_ints[1]
        neg_count = True
    
    if neg_count:
        neg_prod *= list_of_ints[len(list_of_ints)-1]
        
    pos_prod *= list_of_ints[len(list_of_ints)-1] * list_of_ints[len(list_of_ints)-2] * list_of_ints[len(list_of_ints)-3]
    

    if neg_prod > pos_prod:
        return neg_prod
    else:
        return pos_prod