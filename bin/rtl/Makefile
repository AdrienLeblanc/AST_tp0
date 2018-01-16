
main: rtl.jj
	java -jar ../tools/jtb132.jar -p rtl -f rtl.jj
	mkdir -p parser
	java -classpath ../tools/javacc.jar javacc jtb.out.jj
	rm -f jtb.out.jj

clean:
	rm -fr syntaxtree visitor parser jtb.out.jj *~ *.class

