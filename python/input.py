print 'Hello Java.I am Python.Enjoy my funny'

from time import * 

print asctime()
print 'Begin to create one file'
wrfile = open('E:\\Code\\Java\\Test4Android\\src\\python\\Python_file','wb')
rdfile = open('E:\\Code\\Java\\Test4Android\\src\\python\\RunPython.java','rb')
content = rdfile.read()
rdfile.close()
wrfile.write(content)
wrfile.close()
print 'write file process end!'