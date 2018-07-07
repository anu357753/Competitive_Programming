while True:
	

	keys = input()
	has_keys = []
	flag = 0
	for i in range(len(keys)-1):
		key = i+1
		if (key in keys[i]) or (key in has_keys):
			has_keys += keys[i]
			continue
		else:
			flag = 1
			break 

	if flag == 1:
		print "false"
	else:
		print "true"