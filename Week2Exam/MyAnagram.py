
while True:
	
	s = raw_input()
	t = raw_input()

	s = s.lower()
	t = t.lower()

	s_dict = {}

	for i in s:
		if i == " ":
			continue
		if i in s_dict:
			s_dict[i] += 1
		else:
			s_dict[i] = 1

	t_dict = {}

	for i in t:
		if i == " ":
			continue
		if i in t_dict:
			t_dict[i] += 1
		else:
			t_dict[i] = 1

	flag = 0
	if len(s_dict) == len(t_dict):
		for i in s_dict:
			if i in t_dict:
				if s_dict[i] == t_dict[i]:
					continue
				else:
					flag = 1
					break
			else:
				flag = 1 
				break
	else:
		flag = 1

	if flag == 1:
		print "false"
	else:
		print "true"

	print "\n"





