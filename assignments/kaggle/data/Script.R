setwd("~/development/datasciences/assignments/kaggle/data")
train <- read.csv("~/development/datasciences/assignments/kaggle/data/train.csv")
View(train)
test <- read.csv("~/development/datasciences/assignments/kaggle/data/test.csv")
View(test)
str(train)
table(train$Survived)
test$Survived <- rep(0, 418)
submit <- data.frame(PassengerId = test$PassengerId, Survived = test$Survived)
write.csv(submit, file = "theyallperish.csv", row.names = FALSE)
prop.table(table(train$Sex, train$Survived), 1)
test$Survived <- 0
test$Survived[test$Sex == 'female'] <- 1

summary(train$Age)

train$Child <- 0

aggregate(Survived ~ Child + PClass, data=train, FUN=function(x) {sum(x)/length(x)})


library(rpart)

fit <- rpart(Survived ~ Pclass + Sex + Age + SibSp + Parch + Fare + Embarked, data=train, method="class")