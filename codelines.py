import os

def count_lines_in_file(file_path):
    code_lines = 0
    comment_lines = 0
    empty_lines = 0
    in_block_comment = False

    with open(file_path, 'r', encoding='utf-8') as f:
        for line in f:
            stripped_line = line.strip()
            if not stripped_line:
                empty_lines += 1
            elif stripped_line.startswith("//"):
                comment_lines += 1
            elif stripped_line.startswith("/*"):
                comment_lines += 1
                in_block_comment = True
            elif stripped_line.endswith("*/") and in_block_comment:
                comment_lines += 1
                in_block_comment = False
            elif in_block_comment:
                comment_lines += 1
            else:
                code_lines += 1

    return code_lines, comment_lines, empty_lines

def count_lines_in_project(directory):
    total_code_lines = 0
    total_comment_lines = 0
    total_empty_lines = 0

    for root, _, files in os.walk(directory):
        for file in files:
            if file.endswith(".java") or file.endswith(".java.ftl"):
                file_path = os.path.join(root, file)
                code, comment, empty = count_lines_in_file(file_path)
                total_code_lines += code
                total_comment_lines += comment
                total_empty_lines += empty

    return total_code_lines, total_comment_lines, total_empty_lines

project_directory = "."  # 当前目录下的项目
code_lines, comment_lines, empty_lines = count_lines_in_project(project_directory)

print(f"代码行数: {code_lines}")
print(f"注释行数: {comment_lines}")
print(f"空行数: {empty_lines}")
