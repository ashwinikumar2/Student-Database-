public class BST<Y> {

	public TreeNode<PairTree<Pair, Student>> current;
	public TreeNode<PairTree<Pair, Student>> Root;
	
	BST(TreeNode<PairTree<Pair, Student>> Root)
	{
		current=Root;
		this.Root=Root;
	}
	
	public TreeNode<PairTree<Pair, Student>> root()
	{
		return Root;
	}
	
	public int insert(Pair key, Student obj)
	{
		int count=0;
//		System.out.println("ROOT OF THE TABLE= "+Root.data().key().FirstName()+" "+Root.data().key().LastName());
//		if(Root.left()!=null)
//		{
////		System.out.println("LEFT OF ROOT OF THE TABLE= "+Root.left().data().key().FirstName()+" "+Root.left().data().key().LastName());
//		if(Root.left().left()!=null)
//		{
////			System.out.println("LEFT OF LEFT OF ROOT OF THE TABLE= "+Root.left().left().data().key().FirstName()+" "+Root.left().left().data().key().LastName());
//			if(Root.left().left().left()!=null)
//			
//			{
//				System.out.println("LEFT OF LEFT OF LEFT OF ROOT OF THE TABLE= "+Root.left().left().left().data().key().FirstName()+" "+Root.left().left().left().data().key().LastName());
//			}
//			if(Root.left().left().right()!=null)
//			{
//				System.out.println("RIGHT OF LEFT OF LEFT OF ROOT OF THE TABLE= "+Root.left().left().right().data().key().FirstName()+" "+Root.left().left().right().data().key().LastName());
//			}
//		}
//		
		
//		}
//		PairTree<Pair, Student> p=new PairTree<Pair, Student>(key, obj);
//			
//		TreeNode<PairTree<Pair, Student>> N=new TreeNode<PairTree<Pair, Student>>(p);
//			
//		BST<TreeNode<PairTree<Pair, Student>>> tree=new BST<TreeNode<PairTree<Pair, Student>>> (N);
		current=Root;
		while(current!=null)
		{
			count++;
//			System.out.println("Node's key - Given Key = "+(current.data().key().firstname+current.data().key().lastname).compareTo(key.firstname+key.lastname)); 
			if(current.left()==null && current.right()==null)
			{
//				System.out.println("reached where both left and right are null");
				if((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)>0)
				{
//					System.out.println("Attached given node at the left");
					PairTree<Pair, Student> n=new PairTree<Pair, Student>(key, obj);
					TreeNode<PairTree<Pair, Student>> p=new TreeNode<PairTree<Pair, Student>>(n);
					current.Left=p;
				}
				else if((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)<0)
				{
//					System.out.println("Attached given node at the right");
					PairTree<Pair, Student> n=new PairTree<Pair, Student>(key, obj);
					TreeNode<PairTree<Pair, Student>> p=new TreeNode<PairTree<Pair, Student>>(n);
					current.Right=p;
				}
				break;
			}
			else if(current.left()!=null && current.right()==null && ((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)<0))
			{
//				System.out.println("reached where right is null and left is not null. Attached the given node at the right");
				PairTree<Pair, Student> n=new PairTree<Pair, Student>(key, obj);
				TreeNode<PairTree<Pair, Student>> p=new TreeNode<PairTree<Pair, Student>>(n);
				current.Right=p;
				break;
			}
			else if(current.right()!=null && current.left()==null && ((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)>0))
			{
//				System.out.println("reached where left is null and right is not null.Attached the given node at left of current node");
				PairTree<Pair, Student> n=new PairTree<Pair, Student>(key, obj);
				TreeNode<PairTree<Pair, Student>> p=new TreeNode<PairTree<Pair, Student>>(n);
				current.Left=p;
				break;
			}
			else if((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)>0)
			{
//				System.out.println("Simply traversed left");
				current=current.Left;
			}
			else if((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)<0)
			{
//				System.out.println("Simply traversed right");
				current=current.Right;
			}
		}
//		System.out.println("value of count= "+count);
		
		return count;
	}
	
	public int update(Pair key, Student obj)
	{
		PairTree<Pair, Student> p=new PairTree<Pair, Student>(key, obj);
		
		TreeNode<PairTree<Pair, Student>> NodeToBeUpdated=new TreeNode<PairTree<Pair, Student>>(p);
		
		int count=0;
		current=Root;
		while(current!=null)
		{
//			System.out.println("Node's key - Given Key = "+(current.data().key().firstname+current.data().key().lastname).compareTo(key.firstname+key.lastname));
			count++;
			if(current.data().key()==NodeToBeUpdated.data().key())
			{
				
				current.data().value().cgpa=NodeToBeUpdated.data().value().cgpa;
				current.data().value().department=NodeToBeUpdated.data().value().department;
				current.data().value().firstname=NodeToBeUpdated.data().value().firstname;
				current.data().value().hostel=NodeToBeUpdated.data().value().hostel;
				current.data().value().lastname=NodeToBeUpdated.data().value().lastname;
				
				return count;
			}
			else if(current.left()==null && current.right()==null&&(current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)!=0)
			{
//				System.out.println("tttttttttttttttttt");
				return -1;
			}
			
			else if(current.left()!=null && current.right()==null && ((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)<0))
			{
				return -1;
			}
			
			else if(current.right()!=null && current.left()==null && ((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)>0))
			{
				return -1;
			}
			else if((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)>0)
			{
				current=current.Left;
			}
			else if((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)<0)
			{
//				System.out.println("traversed right");
				current=current.Right;
			}
			else if((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)==0)
			{
				current.data().value().cgpa=NodeToBeUpdated.data().value().cgpa; 
				current.data().value().department=NodeToBeUpdated.data().value().department;
				current.data().value().firstname=NodeToBeUpdated.data().value().firstname;
				current.data().value().hostel=NodeToBeUpdated.data().value().hostel;
				current.data().value().lastname=NodeToBeUpdated.data().value().lastname;
				return count;
			}
		}
		if(current==null)
		return -1;
		
		else
		{
			return count;
		}
	}
	
	public int delete(Pair key)
	{
		int count=0;
		
		PairTree<Pair, Student> p=new PairTree<Pair, Student>(key, null);
		
		TreeNode<PairTree<Pair, Student>> NodeToBeUpdated=new TreeNode<PairTree<Pair, Student>>(p);
		
		current=Root;
		TreeNode<PairTree<Pair, Student>> behindCurrent=Root;
//		System.out.println("Insert fnction called again");
		int count1=0;
		while(current!=null )
		{
//			System.out.println("Before editing current is "+current.data().key().FirstName()+" "+current.data().key().LastName());
			count++; 		//FOR CURRENT
//			System.out.println("while in BST has been executed "+count+" times");
//			System.out.println("Node-Given key is"+(current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(current.data().key().FirstName()+current.data().key().LastName()));
//			System.out.println("Current node is "+current.data().key().FirstName()+" "+current.data().key().LastName());
			
			if((NodeToBeUpdated.data().key().FirstName()+" "+NodeToBeUpdated.data().key().LastName()).compareTo(Root.data().key().FirstName()+" "+Root.data().key().LastName())==0)
			{
//				System.out.println("node was found to be root");
				
				
				if(Root.left()==null&&Root.right()==null)
				{
//					System.out.println("Both left and right are null for the Root");
					Root=null;
				}
				else if(Root.left()==null)		//i.e. Root.right()!=null
				{
//					System.out.println("Left child is null and Right child is non null for Root");
					count++;
					PairTree<Pair, Student> StoredData=Root.right().data();
					TreeNode<PairTree<Pair, Student>> RootRightStored=Root.right();
					Root.Data=StoredData;
					if(Root.right().left()==null&&Root.right().right()==null)
					{
//						System.out.println("Right and left child of right of root are null");
						Root.Left=null;
						Root.Right=null;
					}
					else if(Root.right().left()==null)
					{
//						System.out.println("Left child of right of root is null and Right child of right of root is non null");
						count++;
						Root.Left=null;
						Root.Right=Root.right().right();
					}
					else if(Root.right().right()==null)
					{
//						System.out.println("Right child of right of root is null and Left child of right of root is non null");
						count++;
						Root.Left=Root.right().left();
						Root.Right=null;
					}
					else
					{
//						System.out.println("Both left and right child of right of root are non null ");
						count++;
						count++;
						Root.Left=Root.right().left();
						Root.Right=Root.right().right();
					}
					
				}
				
				else if(Root.right()==null)
				{
//					System.out.println("Right child is null and Left child is non null for Root");
					count++;
					PairTree<Pair, Student> StoredData=Root.left().data();
					TreeNode<PairTree<Pair, Student>> RootLeftStored=Root.left();
					
					Root.Data=StoredData;
					if(Root.left().left()==null && Root.left().right()==null)
					{
						Root.Left=null;
						Root.Right=null;
					}
					else if(Root.left().right()==null)
					{
						count++;
						Root.Right=null;
						Root.Left=Root.left().left();
					}
					
					else if(Root.left().left()==null)
					{
						if(Root.left().right()!=null)
						{
							
							TreeNode<PairTree<Pair, Student>> RightOfLeftOfRoot=Root.left();
							TreeNode<PairTree<Pair, Student>> BehindRightOfLeftOfRoot=Root.left();
							TreeNode<PairTree<Pair, Student>> BehindBehindRightOfLeftOfRoot=Root.left();
							while(RightOfLeftOfRoot!=null)
							{
								count++;
								BehindBehindRightOfLeftOfRoot=BehindRightOfLeftOfRoot;
								BehindRightOfLeftOfRoot=RightOfLeftOfRoot;
								RightOfLeftOfRoot=RightOfLeftOfRoot.right();
							}
							
							count--;
							
							if(BehindRightOfLeftOfRoot.left()!=null)
							{
								count++;
								BehindBehindRightOfLeftOfRoot.Right=BehindRightOfLeftOfRoot.left();
							}
							
							Root.Data=BehindRightOfLeftOfRoot.data();
							Root.Left=Root.left();
							
						}
						else
						{
							Root.Data=StoredData;
//							Root.left().Right=Root.right();									//ONLY WHEN ROOT.LEFT!=NULL && ROOT.RIGHT!=NULL
//							count++;														//ONLY WHEN ROOT.LEFT!=NULL && ROOT.RIGHT!=NULL
							
						}
					}
					else
					{
						count++;
						count++;
						Root.Left=Root.left().left();
						Root.Right=Root.left().right();
					}
					
				}
				else																		//PARTIALLY CHECKED
				{
//					System.out.println("Root has non null right and left child");
					count++;					//FOR ACCESSING THE LEFT ELEMENT OF ROOT
					PairTree<Pair, Student> StoredData=Root.left().data();
					TreeNode<PairTree<Pair, Student>> RootLeftStored=Root.left();
//					System.out.println("Value of count= "+count);
					Root.Data=StoredData;
					if(Root.left().left()==null && Root.left().right()==null)
					{
//						System.out.println("Left child of Left of Root and Right child of Left of Root are both null");
						Root.Left=null;
						Root.Right=null;
					}
					else if(Root.left().right()==null)														//CHECKED
					{
//						System.out.println("Right child of Left of Root is null and Left Child of Left of Root is non null");
						count++;
						TreeNode<PairTree<Pair, Student>> p1=Root.left();
						Root.Data=Root.left().data();
						Root.Left=Root.left().left();
						p1=null;
					}
					
					else if(Root.left().left()==null)
					{
//						System.out.println("Left child of Left of Root is null and Right Child of Left of Root is non null");
						if(Root.left().right()!=null)
						{
							
							TreeNode<PairTree<Pair, Student>> RightOfLeftOfRoot=Root.left();
							TreeNode<PairTree<Pair, Student>> BehindRightOfLeftOfRoot=Root.left();
							TreeNode<PairTree<Pair, Student>> BehindBehindRightOfLeftOfRoot=Root.left();
							while(RightOfLeftOfRoot!=null)
							{
								count++;
								BehindBehindRightOfLeftOfRoot=BehindRightOfLeftOfRoot;
								BehindRightOfLeftOfRoot=RightOfLeftOfRoot;
								RightOfLeftOfRoot=RightOfLeftOfRoot.right();
							}
							
							count--;
							
							if(BehindRightOfLeftOfRoot.left()!=null)
							{
								count++;
								BehindBehindRightOfLeftOfRoot.Right=BehindRightOfLeftOfRoot.left();
							}
							
							Root.Data=BehindRightOfLeftOfRoot.data();
							Root.Left=Root.left();
							
						}
						else
						{
							Root.Data=StoredData;
							Root.left().Right=Root.right();									//ONLY WHEN ROOT.LEFT!=NULL && ROOT.RIGHT!=NULL
							count++;														//ONLY WHEN ROOT.LEFT!=NULL && ROOT.RIGHT!=NULL
							
						}
					}
					else																			//PARTIALLY CHECKED
					{
//						System.out.println("Both left and right child of left of Root are non-null");
						
						TreeNode<PairTree<Pair, Student>> RightToLeftOfRoot=Root.left().right();
						
						TreeNode<PairTree<Pair, Student>> BehindRightToLeftOfRoot=Root.left();
						
						
							if(RightToLeftOfRoot.right()!=null)										//CAUTION:CHECK THIS ONCE
							{
								while(RightToLeftOfRoot.left()!=null)
								{	
									count++;
		//							System.out.println("value of count here= "+count);
									BehindRightToLeftOfRoot=RightToLeftOfRoot;
									RightToLeftOfRoot=RightToLeftOfRoot.left();
								}
							
								if(RightToLeftOfRoot.right()!=null)
								{
									count++;
		//							System.out.println("value of count here= "+count);
									BehindRightToLeftOfRoot.Left=RightToLeftOfRoot.right();
									
								}
								Root.Data=RightToLeftOfRoot.data();
								RightToLeftOfRoot=null;
							}
							else																				//CHECKED
							{
//								System.out.println("Right child of Right of Left Of Root is null");
//								System.out.println("RightToLeftOfRoot= "+RightToLeftOfRoot.data().key().FirstName()+" "+RightToLeftOfRoot.data().key().LastName());
								
								count++;
								
								if(RightToLeftOfRoot.left()!=null)
								{
//									System.out.println(" Left of RightToLeftOfRoot= "+RightToLeftOfRoot.left().data().key().FirstName()+" "+RightToLeftOfRoot.left().data().key().LastName());
									count++;
									BehindRightToLeftOfRoot.Right=RightToLeftOfRoot.left();
									Root.Data=RightToLeftOfRoot.data();
								}
								
								RightToLeftOfRoot=null;
							}
						
					}
				}
				break;
				
			}
			
			else if((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)==0)
			{ 
//				count++;				//CAUTION CHECK THIS 
//				System.out.println("current node's key is same as what we are searching");
				
				if(current.Left==null && current.Right==null)									//CHECKED
				{
					count++;
//					System.out.println();
//					System.out.println("left and right child both are null for the current node");
//					System.out.println("Behind Current here is "+behindCurrent.data().key().FirstName()+" "+behindCurrent.data().key().LastName());
//					System.out.println("Left of behind Current here is "+behindCurrent.left().data().key().FirstName()+" "+behindCurrent.left().data().key().LastName());
//					System.out.println("Right of behind Current here is "+behindCurrent.right().data().key().FirstName()+" "+behindCurrent.right().data().key().LastName());
					if(behindCurrent.left()!=null)
					{
					TreeNode<PairTree<Pair, Student>> o=behindCurrent.left();
					if((o.data().key().FirstName()+" "+o.data().key().LastName()).compareTo(current.data().key().FirstName()+" "+current.data().key().LastName()) ==0)
					{
						behindCurrent.Left=null;
					}
					}
					else if (behindCurrent.right()!=null)
					{
						TreeNode<PairTree<Pair, Student>> o=behindCurrent.right();
						if((o.data().key().FirstName()+" "+o.data().key().LastName()).compareTo(current.data().key().FirstName()+" "+current.data().key().LastName()) ==0)
						{
							behindCurrent.Right=null;
						}
					}
					
					
//					System.out.println("Behind Current here now  is "+behindCurrent.data().key().FirstName()+" "+behindCurrent.data().key().LastName());
//					
//					if(behindCurrent.left()!=null)
//					System.out.println("Left of behind Current here now is "+behindCurrent.left().data().key().FirstName()+" "+behindCurrent.left().data().key().LastName());
//					else if(behindCurrent.right()!=null)
//					{
////						System.out.println("Right of behind Current here now is "+behindCurrent.right().data().key().FirstName()+" "+behindCurrent.right().data().key().LastName());
//					}
						
					current=null;
//					return count;
				}
				
				else if(current.Left==null && current.Right!=null)
				{
//					System.out.println("left child is null and right child is non-null for the current node");
					count++;
//					System.out.println("Right of Behind current was "+behindCurrent.right().data().key().FirstName()+" "+behindCurrent.right().data().key().LastName());
//					System.out.println("current node is "+current.data().key().FirstName()+" "+current.data().key().LastName());
//					System.out.println("right of current node is "+current.right().data().key().FirstName()+" "+current.right().data().key().LastName());
//					System.out.println("right of right of current node is "+current.right().right().data().key().FirstName()+" "+current.right().right().data().key().LastName());
					behindCurrent.Right=current.right();
//					System.out.println("Behind current is "+behindCurrent.data().key().FirstName()+" "+behindCurrent.data().key().LastName());
//					System.out.println("Right of Behind current is "+behindCurrent.right().data().key().FirstName()+" "+behindCurrent.right().data().key().LastName());
					current=null;
//					return count;
				}
				else if(current.Right==null && current.Left!=null)							//CHECKED
				{
//					System.out.println("right child is null and left child is non-null for the current node");
					count++;
					behindCurrent.Right=current.left();
					current=null;
//					return count;
				}
				
				else				//traverse through right subtree of behindCurrent till its left is null 				//CHECKED
				{
//					System.out.println("Both right and left child are non-null for the current node");
					
//					System.out.println("value of count= "  +count);
					TreeNode<PairTree<Pair, Student>> RightToCurrent=current.right();
					
					TreeNode<PairTree<Pair, Student>> BehindRightToCurrent=current.right();
					count++;						//FOR ACCESSING THE CURRENT SAME NODE
					
						if(RightToCurrent.left()!=null)										//CAUTION:CHECK THIS ONCE
						{
//							System.out.println("There is a left for right of current node");
							while(RightToCurrent.left()!=null)
							{	
								count++;
	//							System.out.println("value of count here= "+count);
								BehindRightToCurrent=RightToCurrent;
								RightToCurrent=RightToCurrent.left();
							}
//						System.out.println("RightToCurrent now becomes= "+RightToCurrent.data().key().FirstName()+" "+RightToCurrent.data().key().LastName());
						
							if(RightToCurrent.right()!=null)
							{
								count++;
	//							System.out.println("value of count here= "+count);
								BehindRightToCurrent.Left=RightToCurrent.right();
								
							}
							
							current.Data=RightToCurrent.data();
//							System.out.println("RightToCurrent now becomes= "+current.right().data().key().FirstName()+" "+current.right().data().key().LastName());
//							BehindRightToCurrent.Left=null;
							RightToCurrent=null;
//							BehindRightToCurrent.Left=null;
//							RightToCurrent=null;
//							System.out.println("current now becomes= "+current.data().key().FirstName()+" "+current.data().key().LastName());
//							System.out.println("RightToCurrent now becomes= "+current.right().data().key().FirstName()+" "+current.right().data().key().LastName());
//							if(BehindRightToCurrent.left()!=null)
//							System.out.println("Left of behindRightToCurrent now becomes= "+BehindRightToCurrent.left().data().key().FirstName()+" "+BehindRightToCurrent.left().data().key().LastName());
							
						}
						else																			//CHECKED	
						{
//							System.out.println("There is no left for right of current node");
							count++;
//							if(behindCurrent.left()==current)
//							{
//								behindCurrent.Left=current.right();
//							}
//							else
//							{
//								behindCurrent.Right=current.right();
//							}
//							
//							current.right().Left=current.left();
//							
							
							current.Data=current.right().data();
							current.Right=current.right().right();
							
//							System.out.println("Now right to behindCurrent is "+behindCurrent.right().data().key().FirstName()+" "+behindCurrent.right().data().key().LastName());
//							System.out.println("Left of right to behindCurrent "+behindCurrent.right().left().data().key().FirstName()+" "+behindCurrent.right().left().data().key().LastName());
//							current=null;
						}
//						System.out.println("Right of current node is "+current.right().data().key().FirstName()+" "+current.right().data().key().LastName());
//						if(current.right().right()!=null)
//						System.out.println("Right of Righ/t of current node is "+current.right().right().data().key().FirstName()+" "+current.right().right().data().key().LastName());
					
					break;
				}
				break;
			}
			
			else if(current.left()==null && current.right()==null)
			{
//				System.out.println("found match at "+current.data().key().FirstName()+" "+current.data().key().LastName()+"with left and right as null ");
//				count--;
//				System.out.println(""); 
				break;
			}
			
			else if(current.left()!=null && current.right()==null && ((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)<0))
			{
//				System.out.println("found match at "+current.data().key().FirstName()+" "+current.data().key().LastName()+" with left not as null and right as null ");
//				count--;
				break;
			}
			
			else if(current.right()!=null && current.left()==null && ((current.data().key().firstname+" "+current.data().key().lastname).compareTo(key.firstname+" "+key.lastname)>0))
			{
//				System.out.println("found match at "+current.data().key().FirstName()+" "+current.data().key().LastName()+"with right not as null and left as null ");
//				count--;
				break;
			}
			else if((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.FirstName()+" "+key.LastName())>0)	//CHECKED
			{
//				count++;
//				System.out.println("current node's key is greater than what we are searching");
				behindCurrent=current;
				current=current.Left;
//				System.out.println("value of count= "+count);
			}
			
			else if((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.FirstName()+" "+key.LastName())<0) 		//CHECKED
			{
//				System.out.println("current node's key is less than what we are searching");
				behindCurrent=current;
				current=current.right();
//				count++;
//				System.out.println("value of count= "+count);
				
			}
			
			
//			
//			if((current.data().key().firstname+current.data().key().lastname).compareTo(key.firstname+key.lastname)==0)
//				break;
//			System.out.println("After editing current becomes "+current.data().key().FirstName()+" "+current.data().key().LastName());
//			System.out.println("");
			
		}
		
		return count;
	}
	
	@SuppressWarnings("static-access")
	public boolean contains(Pair Key)
	{
		PairTree<Pair, Student> p=new PairTree<Pair, Student>(Key, null);
		
		TreeNode<PairTree<Pair, Student>> NodeToBeChecked=new TreeNode<PairTree<Pair, Student>>(p);
		
		current=Root;
		while(current!=null)
		{
			if((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(NodeToBeChecked.data().key().FirstName()+" "+NodeToBeChecked.data().key().LastName())==0)
			{
				return true;
			}
			
			else if((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(NodeToBeChecked.data().key().FirstName()+" "+NodeToBeChecked.data().key().LastName())>0)
			{
				current=current.Left;
			}
			else if((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(NodeToBeChecked.data().key().FirstName()+" "+NodeToBeChecked.data().key().LastName())<0)
			{
				current=current.Right;
			}
		}
		return false;
		
	}
	
	public Student get(Pair key)
	{
		PairTree<Pair, Student> p=new PairTree<Pair, Student>(key, null);
		
		TreeNode<PairTree<Pair, Student>> NodeToBeUpdated=new TreeNode<PairTree<Pair, Student>>(p);
		
		int count=0;
		current=Root;
		while(current!=null)
		{
//			System.out.println("Node's key - Given Key = "+(current.data().key().firstname+current.data().key().lastname).compareTo(key.firstname+key.lastname));
			count++;
			if((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(NodeToBeUpdated.data().key().FirstName()+" "+NodeToBeUpdated.data().key().LastName())==0)
			{
				return current.data().value();
			}
			else if(current.left()==null && current.right()==null&&((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.firstname+" "+key.LastName())!=0))
			{
				current=current.right();
				break;
			}
			
			else if(current.left()!=null && current.right()==null && ((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.firstname+" "+key.LastName())<0))
			{
				current=current.right();
				break;
			}
			
			else if(current.right()!=null && current.left()==null && ((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.firstname+" "+key.LastName())>0))
			{
				current=current.left();
				break;
			}
			else if((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.firstname+" "+key.LastName())>0)
			{
				current=current.Left;
			}
			else if((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.firstname+" "+key.LastName())<0)
			{
				current=current.Right;
			}
			else if((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.firstname+" "+key.LastName())==0)
			{
				return current.data().value();
			}
		}
		return null;
	}
	
	public String address(Pair key)
	{
		PairTree<Pair, Student> p=new PairTree<Pair, Student>(key, null);
		
		TreeNode<PairTree<Pair, Student>> NodeToBeUpdated=new TreeNode<PairTree<Pair, Student>>(p);
//		System.out.println("Left of Root is "+Root.left().data().key().FirstName()+Root.left().data().key().LastName());
		int count=0;
		current=Root;
		String s="";
		
		while(current!=null)
		{
//			System.out.println("Current is "+current.data().key().firstname+current.data().key().lastname);
//			System.out.println("its right is "+current.left().data().key().FirstName()+" "+current.left().data().key().LastName());
//			System.out.println("Node to be found is "+key.FirstName()+" "+key.LastName());
//			System.out.println("Node's key - Given Key = "+(current.data().key().firstname+current.data().key().lastname).compareTo(key.firstname+key.lastname));
			count++;
//			System.out.println("Current is "+current.data().key().firstname+current.data().key().lastname);
//			System.out.println("Here s is "+s);
//			System.out.println("value of count= "+count);
			if((Root.data().key().FirstName()+" "+Root.data().key().LastName()).compareTo(key.FirstName()+" "+key.lastname)==0)
			{
//				System.out.println("Root is the node to be found");
				count=-2;
				return s;
			}
				//CHECKED
			else if((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.FirstName()+" "+key.lastname)==0)
			{
//				System.out.println("current node is same as node to be found");
				break;
			}
//CHECKED
			else if(current.left()==null && current.right()==null&&((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.FirstName()+" "+key.lastname)!=0))
			{
//				System.out.println("b");
				current=current.left();
				count=-1;
				break;
			}
//CHECKED			
			else if(current.left()!=null && current.right()==null && ((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.FirstName()+" "+key.lastname)<0))
			{
//				System.out.println("c");
				count=-1;
				break;
			}
//CHECEKED			
			else if(current.right()!=null && current.left()==null && ((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.FirstName()+" "+key.lastname)>0))
			{
//				System.out.println("d");
				count=-1;
				break;
			}
//CHECKED
			else if((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.FirstName()+" "+key.lastname)<0)
			{
//				System.out.println("traversed right");
				s +="R";
				current=current.right();
//				System.out.println("Now right is "+current.right().data().key().FirstName()+" "+current.right().data().key().LastName());
			}
//CHECKED
			else if((current.data().key().FirstName()+" "+current.data().key().LastName()).compareTo(key.FirstName()+" "+key.lastname)>0)
			{
//				System.out.println("Simply traversed left");
				s +="L";
				current=current.left();
			}
			
			
		}
//		System.out.println("current = "+current);
		if(count==-2)
		{
			s="Root";
			return s;
		}
		if(count==-1)										//CHECKED
		{
//			System.out.println("count is -1");
			return null;
		}
		else
			return s;
		
		
		
		
		
		
		
//		PairTree<Pair, Student> p=new PairTree<Pair, Student>(Key, null);
//		
//		TreeNode<PairTree<Pair, Student>> NodeToBeChecked=new TreeNode<PairTree<Pair, Student>>(p);
//		
//		String s="";
//		current=Root;
//		while(current!=null)
//		{
//			if(current.data().key()==NodeToBeChecked.data().key())
//			{
//				break;
//			}
//			
//			else if((current.data().key().firstname).compareTo(NodeToBeChecked.data().key().firstname)>0)
//			{
//				s +="L";
//				current=current.Left;
//			}
//			else if((current.data().key().firstname).compareTo(NodeToBeChecked.data().key().firstname)<0)
//			{
//				s +="R";
//				current=current.Right;
//			}
//		}
//		if(current==null)
//		{
//			System.out.println("E");
//			return null;
//		}
//		else
//			return s;
	}
}
