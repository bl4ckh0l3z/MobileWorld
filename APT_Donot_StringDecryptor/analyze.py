# Decryptor for Donot samples strings;
# tested on e1c24030653d15ee673627bf28f165d1a30be5027b8cd4186ac6bfd9809e8cb8.
# by bl4ckh0l3z

import re
import r2pipe
import subprocess

import colorama
from colorama import Fore, Back
colorama.init()

FNAME = "./e1c24030653d15ee673627bf28f165d1a30be5027b8cd4186ac6bfd9809e8cb8_unzip/classes.dex"

print("[*] Loading file '%s'" % (FNAME))
r = r2pipe.open(FNAME, flags=['-2'])
r.cmd('aaaa')

print("[*] Retrieving encrypted strings and xrefs, then trying to decrypt strings...")
xref = r.cmd('axt @`is~Le/b/a/f/a.method.a[2]`')
for xl in xref.split('\n'):
	if xl != "":
		x = xl.split()[1]
		if x != "":
			arg = r.cmd('pd -1 @%s' % (x))
			if 'const-string' in arg and 'str.' in arg:
				m = re.search(', str.[a-zA-Z0-9]+ ;', arg)
				if m:
					arg_encr = (r.cmd('psz @%s' % (m.group(0).replace(', ', '').replace(' ;', '')))).replace('\n', '')
					if arg_encr != "":
						print(Fore.BLUE + "  xref: %s ; arg: %s" % (x, arg_encr))
						arg_plain = ((subprocess.run(["java", "Decryptor", arg_encr, "2>", "/dev/null"], capture_output=True)).stdout).decode('utf-8').replace('\n', '')
						print(Fore.WHITE + "    arg_encr: " + Fore.YELLOW + arg_encr + Fore.WHITE + " ;" + " arg_plain: " + Fore.RED + arg_plain)
