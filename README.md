[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c1af0dd1875a4d529af1773531452dc5)](https://app.codacy.com/app/vitalynec/focus_task?utm_source=github.com&utm_medium=referral&utm_content=vitalynec/focus_task&utm_campaign=Badge_Grade_Dashboard)

Сортировка слиянием нескольких файлов

### Параметры программы задаются при запуске через аргументы командной строки:
1. режим сортировки (`-a` или `-d`), необязательный, по умолчанию сортируем по возрастанию;
2. тип данных (`-s` или `-i`), обязательный;
3. имя выходного файла, обязательное;
4. остальные параметры – имена входных файлов, не менее одного.

Примеры запуска из командной строки для Windows:
* `java Launcher -i -a out.txt in.txt` (для целых чисел по возрастанию)
* `sort-it.exe -s out.txt in1.txt in2.txt in3.txt` (для строк по возрастанию)
* `sort-it.exe -d -s out.txt in1.txt in2.txt` (для строк по убыванию)
