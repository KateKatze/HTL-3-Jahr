const MainFacade = {
    studentDAO: null,
    studentList: [],
  
    addStudent: function(student) {
      this.studentList.push(student);
      this.studentDAO.addStudent(student);
    },
  
    removeStudent: function(student) {
      const index = this.studentList.indexOf(student);
      if (index !== -1) {
        this.studentList.splice(index, 1);
        this.studentDAO.removeStudent(student);
      }
    },
  
    requestStudentList: function() {
      this.studentDAO.requestStudentList();
    },
  
    onStudentListLoaded: function(studentList) {
      this.studentList = studentList;
      console.log("Student list loaded:", this.studentList);
    }
  };
  