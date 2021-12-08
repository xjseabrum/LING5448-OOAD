import user_model

# temp=user_model.UserModel()
document = {"_id": "test2", "name": "test2"}
'''
if temp.check_if_id_exist(document["_id"]):
    print("id exisited")
else:
    temp.create(document)
'''
'''
r=temp.update({"_id":"test2"}, {"name":"update test"})
print(r)
'''
'''
r=temp.retrieve({"_id":"test2"})
print(type(r[0]))
print(r[0]["name"])
'''
# r=temp.delete({"_id":"test2"})

r = user_model.UserModel.retrieve({"_id": "test1"})
print(r)
