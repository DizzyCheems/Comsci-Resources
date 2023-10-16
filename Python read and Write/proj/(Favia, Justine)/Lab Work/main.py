# main.py

from subjects import get_subject_unit, get_subject_desc, get_course_desc

def check_file(file_name):
    try:
        with open(file_name, 'r'):
            pass
        return True
    except FileNotFoundError:
        return False

def display_student_info(output_file, full_name, course, subjects_list, subject_units, total_units):
    output_file.write("---------------------------------------------- \n")
    output_file.write("Student Name: {}\n".format(full_name))
    output_file.write("Course: {}\n".format(get_course_desc(course)))
    output_file.write("Subjects Enrolled: \n")

    for subject_code in subjects_list:
        subject_description = get_subject_desc(subject_code)
        subject_unit = get_subject_unit(subject_code)
        output_file.write("{} - {} - {} units\n".format(subject_code, subject_description, subject_unit))

    output_file.write("\nTotal Units: {}\n\n".format(total_units))
    output_file.write("---------------------------------------------- \n")

def input_from_console():
    first_name = input("Enter first name: ")
    middle_name = input("Enter Middle Initial: ")
    last_name = input("Enter last name: ")
    middle_initial = middle_name[0]  
    full_name = "{} {}. {}".format(first_name, middle_initial, last_name)
    
    course = input("Enter student course: ")
    
    while True:
        try:
            num_subjects = int(input("Enter the number of subjects: "))
            break
        except ValueError:
            print("Invalid input. Please enter an integer for the number of subjects.")
    
    subjects_list = []
    for _ in range(num_subjects):
        subject_code = input(f"Enter subject code for subject {_ + 1}: ")
        subjects_list.append(subject_code)
    
    subject_units = [get_subject_unit(subject_code) for subject_code in subjects_list]
    total_units = sum([units for units in subject_units if isinstance(units, int)])
    
    return full_name, course, subjects_list, subject_units, total_units

def input_from_file(file_name):
    if not check_file(file_name):
        print(f"Error: {file_name} not found.")
        return None
    
    with open(file_name, "r") as input_file:
        lines = input_file.readlines()
    
    student_info = []
    students = []
    for line in lines:
        line = line.strip()
        if line:
            student_info.append(line)
        else:
            students.append(student_info)
            student_info = []
    
    output_file = open("output.txt", "w")  
    
    for student_data in students:
        first_name = student_data[0]
        middle_name = student_data[1]
        last_name = student_data[2]
        middle_initial = middle_name[0]
        full_name = "{} {}. {}".format(first_name, middle_initial, last_name)
        course = student_data[3]
        subjects_list = student_data[4].split(", ")
    
        subject_units = [get_subject_unit(subject_code) for subject_code in subjects_list]
        total_units = sum([units for units in subject_units if isinstance(units, int)])
    
        display_student_info(output_file, full_name, course, subjects_list, subject_units, total_units)
    
    output_file.close()  # Close the output file when done
    
def student():
    choice = input("Enter '1' to input from console or '2' to use data from 'input.txt': ")
    
    if choice == "1":
        full_name, course, subjects_list, subject_units, total_units = input_from_console()
        if full_name:
            with open("output.txt", "a") as output_file:
                display_student_info(output_file, full_name, course, subjects_list, subject_units, total_units)
    elif choice == "2":
        input_from_file("input.txt")
    else:
        print("Invalid choice. Please enter '1' or '2'.")
        return

if __name__ == "__main__":
    student()
