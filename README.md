Необходимо реализовать консольное CRUD приложение, которое имеет следующие сущности:

Project
Category
Customer
ProjectStatus (enum ACTIVE, FINISHED, DELETED)

Project -> Set<Category> categories + Customer customer
Project -> ProjectStatus

В качестве хранилища данных необходимо использовать текстовые файлы:
projects.txt, categories.txt, customers.txt

Пользователь в консоли должен иметь возможность создания, получения, редактирования и удаления данных.

Слои:
model - POJO класы
repository - классы, реализующие доступ к текстовым файлам
controller - обработка запросов от пользователя
view - все данные, необходимые для работы с консолью

Например: Project, ProjectRepository, ProjectController, ProjectView и т.д.


Для репозиторного слоя желательно использовать базовый интерфейс:
interface GenericRepository<T,ID>

interface ProjectRepository extends GenericRepository<Project, Long>

class JavaIOProjectRepositoryImpl implements ProjectRepository