
FILES=$(addprefix bin/main/, $(addsuffix .class, Teacher Student Exam))

TEST=$(addprefix bin/test/, $(addsuffix .class, TeacherTest StudentTest ExamTest))

.PHONY: default makebin clean

default: $(FILES)
	@echo "compilation successful"

test: $(TEST)
	@echo "test compilation successful"

bin/%.class: src/%.java | makebin
	@echo "compiling $<"
	@javac -Werror -d bin/ -cp ${CLASSPATH}:bin:src/main:src/test -Xlint $<

bin/%.class: test/%.java | makebin
	@echo "compiling $<"
	@javac -Werror -d bin/ -cp ${CLASSPATH}:bin:src/main:src/test -Xlint $<

clean:
	@[ ! -d bin ] || echo "removing bin directory"
	@[ ! -d bin ] || rm -r bin

makebin:
	@[  -d bin ] || echo "making bin directory"
	@[  -d bin ] || mkdir bin
