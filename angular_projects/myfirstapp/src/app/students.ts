export interface Student {
  id: number;
  name: string;
  contact: string;
  intro: string;
  subjects: Array<Grade>;
}

export interface Grade {
  subject: string;
  score: number;
}

export const students: Array<Student> = [
  {
    id: 101,
    name: 'Joseph',
    contact: '12345678',
    intro: 'Hi my name is Joseph',
    subjects: [
      { subject: 'Quantitative Finance', score: 90 },
      { subject: 'Statistics', score: 90 },
      { subject: 'Math', score: 90 },
      { subject: 'Finance', score: 90 },
    ],
  },
  {
    id: 102,
    name: 'Jason',
    contact: '23456789',
    intro: 'Hi my name is Jason',
    subjects: [
      { subject: 'Finance', score: 80 },
      { subject: 'Econs', score: 80 },
      { subject: 'Business', score: 80 },
      { subject: 'Accounting', score: 80 },
    ],
  },
  {
    id: 103,
    name: 'Jennie',
    contact: '34567890',
    intro: 'Hi my name is Jennie',
    subjects: [
      { subject: 'Math', score: 70 },
      { subject: 'Physics', score: 70 },
      { subject: 'Chemistry', score: 70 },
      { subject: 'Accounting', score: 70 },
    ],
  },
];
