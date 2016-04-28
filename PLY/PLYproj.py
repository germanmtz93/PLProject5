""" This will parse the data from the text file naics07.txt
which is a condensed version of 2-6 digit 2007 Code Files from The North American Industry Classification System.


We used the following unix cmmd to run:
    cat naics07.txt | python PLYproj.py
"""

tokens = ('SEQ', 'FARM', 'MANU', 'WHOLE', 'TRANS', 'INTEGER')
literals = ['.', ',', ]

# Tokens
t_SEQ = r'^Seq.*$'
t_FARM  = r'.*Farming.*$'
t_MANU    = r'.*Manufacturing.*$'
t_WHOLE    = r'.*Wholesalers.*$'
t_TRANS = r'.*Transportation.*$'

def t_INTEGER(t):
    r'\d+'
    try:
        t.value = int(t.value)
    except ValueError:
        print("Integer value too large %d", t.value)
        t.value = 0
    return t

# Ignored characters
t_ignore = " \r"

def t_newline(t):
    r'\n+'
    t.lexer.lineno += t.value.count("\n")

def t_error(t):
    print("Illegal character '%s'" % t.value[0])
    t.lexer.skip(1)

# Build the lexer
import ply.lex as lex   # ply.lex comes from the ply folder in the PLY download.
lexer = lex.lex()

# Parsing rules

global time_step
time_step = 0

global rows
rows = 0

def p_start(t):
    '''start : SEQ
             | farm
             | manu
             | whole
             | trans
             | empty
    '''
    #if len (t) > 0 and t[1] != None:
        #global rows
        #rows += 1
    #print ("Saw: ", t[1])

def p_data(t):
    'data : INTEGER INTEGER'
    t[0] = str(t[2])

def p_farm(t):
    'farm : data FARM'
    print ('NAICS US Code: ' + str(t[1]) + ' ' + 'NAICS US Title: ' + str(t[2]))

def p_manu(t):
    'manu : data MANU'
    print ('NAICS US Code: ' + str(t[1]) + ' ' + 'NAICS US Title: ' + str(t[2]))

def p_whole(t):
    'whole : data WHOLE'
    print ('NAICS US Code: ' + str(t[1]) + ' ' + 'NAICS US Title: ' + str(t[2]))

def p_trans(t):
    'trans : data TRANS'
    print ('NAICS US Code: ' + str(t[1]) + ' ' + 'NAICS US Title: ' + str(t[2]))

def p_empty(t):
    'empty : '
    pass

def p_error(t):
    if t == None:
        print("Syntax error at '%s'" % t)

    else:
        print("Syntax error at '%s'" % t.value)


import ply.yacc as yacc   # ply.yacc comes from the ply folder in the PLY download.
parser = yacc.yacc()

while True:
    try:
        s = raw_input('')
    except EOFError:
        break
    parser.parse(s)

