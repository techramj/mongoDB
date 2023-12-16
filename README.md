# One 
    db.articles.insertMany([
        {   _id:1, 
            code:"xyz", 
            tags:["school","book","bag", "headphone","appliance"],
            qty:[
                {size:"S", num:10,color:"blue" },
                {size:"M", num:40,color:"blue" },
                {size:"L", num:100,color:"red" }
            ]
        },
        {   _id:2, 
            code:"abc", 
            tags:["school","book","appliance"],
            qty:[
                {size:"S", num:100,color:"blue" },
                {size:"M", num:46,color:"blue" },
                {size:"L", num:10,color:"red" }
            ]
        },
        {   _id:3, 
            code:"pqr", 
            tags:["bag", "headphone","appliance"],
            qty:[
                {size:"6", num:10,color:"green" },
                {size:"6", num:40,color:"brown" },
                {size:"8", num:100,color:"red" }
            ]
        },
        {   _id:4, 
            code:"lmn", 
            tags:["school","book","bag"],
            qty:[
                {size:"S", num:10,color:"blue" },
                {size:"M", num:40,color:"blue" },
                {size:"L", num:100,color:"red" }
            ]
        },
        {   _id:5, 
            code:"efg", 
            tags:[ "headphone","appliance"],
            qty:[
                {size:"S", num:10,color:"blue" },
                {size:"M", num:40,color:"blue" },
                {size:"L", num:100,color:"red" }
            ]
        },
        {   _id:6, 
            code:"mno", 
            tags:["school","book"],
            qty:[
                {size:"S", num:10,color:"blue" },
                {size:"M", num:40,color:"blue" },
                {size:"L", num:100,color:"red" }
            ]
        }
    ]);



# Two
    db.inventory.insertMany([
        {_id:1, "result":[80,89.98] },
        {_id:2, "result":[80,82.86] },
        {_id:3, "result":[10,40, 50] },
        {_id:4, "result":[5,8, 8] }
    ]);



# three

      db.students.insertMany(
      [
          {_id:1, semester:1, grades:[70,75,85]},
          {_id:2, semester:1, grades:[80,85,95]},
          {_id:3, semester:1, grades:[70,75,90]},
          {_id:4, semester:2, grades:[70,75,65]},
          {_id:5, semester:2, grades:[50,75,45]},
          {_id:6, semester:2, grades:[40,45,55]},
          {_id:7, semester:3, grades:[
                                      {grade:80, mean:75, std:8},
                                      {grade:85, mean:75, std:7},
                                      {grade:90, mean:75, std:6},
                                      ]},
          {_id:8, semester:3, grades:[
                                      {grade:92, mean:88, std:8},
                                      {grade:75, mean:60, std:7},
                                      {grade:80, mean:85, std:6},
                                      ]},
      ]
      );
      
      db.students.find({semester:1, grades: {$gt: 80} })


db.students.find({semester:1, grades: {$gt: 80} }, {"grades.$" :1})

db.students.find({semester:3, "grades.mean": {$gt: 80} })



4. slice operator
db.students.find({}, {"grades": {$slice:2}});
db.students.find({semester :{$eq:1}}, {"grades": {$slice:2}});

;
