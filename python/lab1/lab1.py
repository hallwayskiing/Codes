import sys
import pandas as pd
import numpy as np
import matplotlib
import matplotlib.pyplot as plt

df = pd.read_csv('AmesHousing.csv')

#First 6 rows of the dataframe
print(df.head(6))

#Number of samples and attributes
print(f'num samples={df.shape[0]}, num attributes={df.shape[1]}')

#Drop rows with NaN values
df=df.dropna()

#vector of SalePrice
y = df['SalePrice'].values

#Mean house price and fraction above 120k
print(f'mean house price={np.mean(y)}, fraction above 120k={np.mean(y > 120)}')

#vector of TotRms AbvGrd
x=df['TotRms AbvGrd'].values

#Scatter plot of SalePrice vs. TotRms AbvGrd
plt.figure(figsize=(10, 6))
plt.scatter(x, y, alpha=0.6)
plt.xlabel('Total Rooms Above Ground')
plt.ylabel('Sale Price ($1,000)')
plt.grid(True, alpha=0.3)
plt.title('House Price vs. Total Rooms Above Ground')
#plt.show()

#linear regression model
def fit_linear(x,y):
    """
    Given vectors of data points (x,y), performs a fit for the linear model:
       y = beta0 + beta1*x,
    The function returns beta0, beta1, and loss, where loss is the sum-of-squares loss of.
    """    
    x_mean = np.mean(x)
    y_mean = np.mean(y)
    
    beta1 = np.sum((x - x_mean) * (y - y_mean)) / np.sum((x - x_mean) ** 2)
    beta0 = y_mean - beta1 * x_mean
    loss = np.sum((y - beta0 - beta1 * x) ** 2)

    return beta0, beta1, loss

beta0, beta1, loss = fit_linear(x, y)
print(f'beta0={beta0}, beta1={beta1}, loss={loss}')

# Replot with regression line
yp = beta0 + beta1 * x
plt.figure(figsize=(10, 6))
plt.plot(x, yp, color='red')
plt.xlabel('Total Rooms Above Ground')
plt.ylabel('Sale Price ($1,000)')
plt.title('Linear Regression of Sale Price vs. Total Rooms Above Ground')
plt.grid(True, alpha=0.3)
#plt.show()

#Record losses of all attributes
table=pd.DataFrame(columns=['Attribute', 'Loss'])
for i,col in enumerate(df.columns):
    x=df[col].values
    _, _, loss = fit_linear(x, y)
    table.loc[i] = [col, loss]

print(table.sort_values(by='Loss', ascending=True))
print('Ground Living Area predicts House Price the best. It directly measures the amount of livable space in a house,')
print('which is a primary driver of value in real estate.')

#Line approximate
def fit_approx(x,y):
    """
    Given vectors of data points (x,y), performs an *approximate* fit for the linear model:
       y = beta0 + beta1*x,
    under the sum-of-squares loss. The min_loss returned is the lost of the best beta0 and beta1 you found.
    """
    min_loss=sys.maxsize
    min_beta0=0
    min_beta1=0
    for beta0 in np.arange(-50,50,.1):
        for beta1 in np.arange(-1,1,.005):
            loss = np.sum((y - beta0 - beta1 * x) ** 2)
            if 0<loss<min_loss:
                min_beta0=beta0
                min_beta1=beta1
                min_loss=loss

    return min_beta0, min_beta1, min_loss

x=df['Gr Liv Area'].values
y=df['SalePrice'].values
beta0_linear, beta1_linear, loss_linear = fit_linear(x, y)
print(f'beta0_linear={beta0_linear}, beta1_linear={beta1_linear}, loss_linear={loss_linear}')
beta0_approx, beta1_approx, loss_approx = fit_approx(x, y)
print(f'beta0_approx={beta0_approx}, beta1_approx={beta1_approx}, loss_approx={loss_approx}')

# Replot with regression line
yp = beta0_linear + beta1_linear * x
plt.figure(figsize=(10, 6))
plt.plot(x, yp, color='red')
plt.xlabel('Ground Live Area')
plt.ylabel('Sale Price ($1,000)')
plt.title('Linear Regression of Sale Price vs. Ground Live Area')
plt.grid(True, alpha=0.3)
#plt.show()

# Replot with approx line
yp = beta0_approx + beta1_approx * x
plt.figure(figsize=(10, 6))
plt.plot(x, yp, color='red')
plt.xlabel('Ground Live Area')
plt.ylabel('Sale Price ($1,000)')
plt.title('Linear Approx Model of Sale Price vs. Ground Live Area')
plt.grid(True, alpha=0.3)
#plt.show()

def fit_approx_l1(x,y):
    """
    Given vectors of data points (x,y), performs an *approximate* fit for the linear model:
       y = beta0 + beta1*x,
    under the least absolute deviations loss.
    """
    min_loss=sys.maxsize
    min_beta0=0
    min_beta1=0
    for beta0 in np.arange(-50,50,.1):
        for beta1 in np.arange(-1,1,.005):
            loss = np.sum(abs(y - beta0 - beta1 * x))
            if 0<loss<min_loss:
                min_beta0=beta0
                min_beta1=beta1
                min_loss=loss

    return min_beta0, min_beta1, min_loss

def fit_approx_max(x,y):
    """
    Given vectors of data points (x,y), performs an *approximate* fit for the linear model:
       y = beta0 + beta1*x,
    under the max loss.
    """
    min_loss=sys.maxsize
    min_beta0=0
    min_beta1=0
    for beta0 in np.arange(-50,50,.1):
        for beta1 in np.arange(-1,1,.005):
            loss = np.max(abs(y - beta0 - beta1 * x))
            if 0<loss<min_loss:
                min_beta0=beta0
                min_beta1=beta1
                min_loss=loss

    return min_beta0, min_beta1, min_loss

beta0_approx_l1, beta1_approx_l1, loss_approx_l1 = fit_approx_l1(x, y)
beta0_approx_max, beta1_approx_max, loss_approx_max = fit_approx_max(x, y)
print(f'beta0_approx_l1={beta0_approx_l1}, beta1_approx_l1={beta1_approx_l1}, loss_approx_l1={loss_approx_l1}')
print(f'beta0_approx_max={beta0_approx_max}, beta1_approx_max={beta1_approx_max}, loss_approx_max={loss_approx_max}')

plt.figure(figsize=(10, 6))
#Scatter points
plt.scatter(x,y,label='Scatter points')
# Squared loss line
yp1 = beta0_approx + beta1_approx * x
plt.plot(x, yp1, color='red',label='Squared loss')
#l1 loss line
yp2 = beta0_approx_l1 + beta1_approx_l1 * x
plt.plot(x, yp2, color='green',label='$\ell_1$ loss')
#lmax loss line
yp3 = beta0_approx_max + beta1_approx_max * x
plt.plot(x, yp3, color='blue',label=f'$\ell_\infty$ loss')
plt.xlabel('Ground Live Area')
plt.ylabel('Sale Price ($1,000)')
plt.title('3 Kinds of Linear Approx of Ground Live Area vs. Sale Price')
plt.legend()
plt.grid(True, alpha=0.3)
#plt.show()

# Prepare Lot Area data
x_lot = df['Lot Area'].values
#find out the optimal range of lot area betas
beta0,beta1,loss=fit_linear(x_lot,y)
print(f'beta0_lot={beta0},beta1_lot={beta1}')

#change the brute forcing range
def fit_approx_sq_lot(x,y):
    """
    Given vectors of data points (x,y), performs an *approximate* fit for the linear model:
       y = beta0 + beta1*x,
    under the sum-of-squares loss. The min_loss returned is the lost of the best beta0 and beta1 you found.
    """
    min_loss=sys.maxsize
    min_beta0=0
    min_beta1=0
    for beta0 in np.arange(100,200,.5):
        for beta1 in np.arange(-1,1,.0005):
            loss = np.sum((y - beta0 - beta1 * x) ** 2)
            if 0<loss<min_loss:
                min_beta0=beta0
                min_beta1=beta1
                min_loss=loss

    return min_beta0, min_beta1, min_loss

def fit_approx_l1_lot(x,y):
    """
    Given vectors of data points (x,y), performs an *approximate* fit for the linear model:
       y = beta0 + beta1*x,
    under the least absolute deviations loss.
    """
    min_loss=sys.maxsize
    min_beta0=0
    min_beta1=0
    for beta0 in np.arange(100,200,.5):
        for beta1 in np.arange(-1,1,.0005):
            loss = np.sum(abs(y - beta0 - beta1 * x))
            if 0<loss<min_loss:
                min_beta0=beta0
                min_beta1=beta1
                min_loss=loss

    return min_beta0, min_beta1, min_loss

def fit_approx_max_lot(x,y):
    """
    Given vectors of data points (x,y), performs an *approximate* fit for the linear model:
       y = beta0 + beta1*x,
    under the max loss.
    """
    min_loss=sys.maxsize
    min_beta0=0
    min_beta1=0
    for beta0 in np.arange(100,200,.5):
        for beta1 in np.arange(-1,1,.0005):
            loss = np.max(abs(y - beta0 - beta1 * x))
            if 0<loss<min_loss:
                min_beta0=beta0
                min_beta1=beta1
                min_loss=loss

    return min_beta0, min_beta1, min_loss

beta0_sq_lot, beta1_sq_lot, loss_sq_lot = fit_approx_sq_lot(x_lot, y)
beta0_l1_lot, beta1_l1_lot, loss_l1_lot = fit_approx_l1_lot(x_lot, y)
beta0_max_lot, beta1_max_lot, loss_max_lot = fit_approx_max_lot(x_lot, y)

print(f'beta0_sq_lot={beta0_sq_lot}, beta1_sq_lot={beta1_sq_lot}, loss_sq_lot={loss_sq_lot}')
print(f'beta0_l1_lot={beta0_l1_lot}, beta1_l1_lot={beta1_l1_lot}, loss_l1_lot={loss_l1_lot}')
print(f'beta0_max_lot={beta0_max_lot}, beta1_max_lot={beta1_max_lot}, loss_max_lot={loss_max_lot}')

# Create the plot with three different linear fits
plt.figure(figsize=(10, 6))
plt.scatter(x_lot, y, label='Scatter points')
# Squared loss line
y_sq_lot = beta0_sq_lot + beta1_sq_lot * x_lot
plt.plot(x_lot, y_sq_lot,color='red', label='Squared loss')
# L1 loss line
y_l1_lot = beta0_l1_lot + beta1_l1_lot * x_lot
plt.plot(x_lot, y_l1_lot,color='green', label='$\ell_1$ loss')
# L∞ loss line
y_max_lot = beta0_max_lot + beta1_max_lot * x_lot
plt.plot(x_lot, y_max_lot, color='blue', label='$\ell_\infty$ loss')
plt.xlabel('Lot Area')
plt.ylabel('Sale Price ($1,000)')
plt.title('3 Kinds of Linear Approx of Lot Area vs. Sale Price')
plt.legend()
plt.grid(True, alpha=0.3)
plt.show()

# Discussion about how choice of loss function affected the fit:
print("\nDiscussion:")
print("The choice of loss function significantly affected the fit for Lot Area due to the presence of extreme outliers.")
print("The l1 loss (green line) was most robust to outliers, while the Squared loss (blue line) was most sensitive to them.")
