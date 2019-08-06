## Сортировка слиянием нескольких файлов

### Параметры программы задаются при запуске через аргументы командной строки:
1. режим сортировки (`-a` или `-d`), необязательный, по умолчанию сортируем по возрастанию;
2. тип данных (`-s` или `-i`), обязательный;
3. имя выходного файла, обязательное;
4. остальные параметры – имена входных файлов, не менее одного.

Примеры запуска из командной строки для Windows:
* `java -jar focus_task.jar -i -a out.txt in.txt` (для целых чисел по возрастанию)
* `java -jar focus_task.jar -s out.txt in1.txt in2.txt in3.txt` (для строк по возрастанию)
* `java -jar focus_task.jar -s -d out.txt in1.txt in2.txt` (для строк по убыванию)
