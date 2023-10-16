def get_subjects():
    num_subjects = int(input("Enter the number of subjects you want to enroll: "))
    subjects = []

    for i in range(num_subjects):
        subject_code = input(f"Enter subject code for subject {i + 1}: ")
        subjects.append(subject_code)

    return subjects

subject_descriptions = {
    "CSPC 102": "Discrete Structures 2",
    "CSPC 106": "Automata Theory & Formal Languages",
    "CSPC 107": "Organization & Architecture",
    "CSPC 109": "Programming Languages",
    "CSELEC 1": "Computational Science",
    "CSELEC 2": "Graphics & Visual Computing",
    "AHE 111": "Great Books",
    "CSPC 108": "Software Engineering"
}


subject_units = {
    "CSPC 102": 3,
    "CSPC 106": 3,
    "CSPC 107": 3,
    "CSPC 109": 5,
    "CSELEC 1": 5,
    "CSELEC 2": 5,
    "AHE 111": 3,
    "CSPC 108": 5
}

def get_subject_desc(subject_code):
    return subject_descriptions.get(subject_code, "Unknown")


def get_subject_unit(subject_code):
    return subject_units.get(subject_code, "Unknown")

course_descriptions = {
    "BSCS": "Bachelor of Science in Computer Science",
    "BSIT": "Bachelor of Science in Information Technology",
    "BLIS": "Bachelor in Library Science"
}


def get_course_desc(course_code):
    return course_descriptions.get(course_code, "Unknown")