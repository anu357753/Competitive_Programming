def get_products_of_all_ints_except_at_index(int_list):

    # Make a list with the products
    if len(int_list) < 2:
        return "Error"
        
    list2 = [1] * len(int_list)
    list3 = [1] * len(int_list)
    ans = 1
    for i in range(0,len(int_list)):
        list2[i] = ans
        ans *= int_list[i]
    
    int_list.reverse()
    ans = 1
    for i in range(0,len(int_list)):
        list3[i] = ans
        ans *= int_list[i]
        
    list3.reverse()
    
    for i in range(0,len(list2)):
        list2[i] *= list3[i]
        
    
        

    return list2


input_list = input()
print get_products_of_all_ints_except_at_index(input_list)